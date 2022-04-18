/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example.stackdriver.example;

import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.*;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Timestamps;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        var topics = List.of("test-pub-sub-metrics");
        try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
            ListTimeSeriesRequest request = ListTimeSeriesRequest.newBuilder()
                    .setName(ProjectName.of("pubsub-poc-337713").toString())
                    .setFilter(String.format(
                            "metric.type = \"pubsub.googleapis.com/topic/send_request_count\"" +
                                    " AND " +
                                    "resource.labels.topic_id = monitoring.regex.full_match(\"%s\")",
                            String.join("|", topics)))
                    .setInterval(TimeInterval.newBuilder()
                            .setEndTime(Timestamps.fromMillis(System.currentTimeMillis()))
                            .build())
                    .setAggregation(Aggregation.newBuilder()
                            .addGroupByFields("resource.labels.topic_id")
                            .setAlignmentPeriod(Duration.newBuilder().setSeconds(86400).build())
                            .setCrossSeriesReducer(Aggregation.Reducer.REDUCE_SUM)
                            .setPerSeriesAligner(Aggregation.Aligner.ALIGN_SUM)
                            .build())
                    .build();


            List<TimeSeries> timeSeriesList = metricServiceClient.listTimeSeries(request).getPage().getResponse()
                    .getTimeSeriesList();
            timeSeriesList
                    .forEach(timeSeries -> {
                        System.out.printf("%s: %d\n", timeSeries.getResource().getLabelsMap().get("topic_id"),
                                timeSeries.getPoints(0).getValue().getInt64Value());
                    });
        }
    }
}
