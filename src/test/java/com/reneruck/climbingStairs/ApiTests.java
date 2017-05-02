package com.reneruck.climbingStairs;

import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.testkit.JUnitRouteTest;
import akka.http.javadsl.testkit.TestRoute;
import org.junit.Test;

/**
 * Created by Rene on 01/05/2017.
 */
public class ApiTests extends JUnitRouteTest {

    TestRoute testRoute = testRoute(new HttpServer().createRoute());

    @Test
    public void should_return_not_found_for_missing_stepsPerFlight_parameter() {
        testRoute.run(HttpRequest.GET("/steps?stepsPerStride=3"))
                .assertStatusCode(404);
    }

    @Test
    public void should_return_not_found_for_missing_stepsPerStride_parameter() {
        testRoute.run(HttpRequest.GET("/steps?stepsPerFlight=[17]"))
                .assertStatusCode(404);
    }

    @Test
    public void should_return_internal_error_for_malformed_input() {
        testRoute.run(HttpRequest.GET("/steps?stepsPerFlight=17,17&stepsPerStride=3"))
                .assertStatusCode(500);
    }

    @Test
    public void should_return_correct_result_for_first_example() {
        testRoute.run(HttpRequest.GET("/steps?stepsPerFlight=[17]&stepsPerStride=3"))
                .assertStatusCode(200)
                .assertEntity("{\"steps\":6}");
    }

    @Test
    public void should_return_correct_result_for_second_example() {
        testRoute.run(HttpRequest.GET("/steps?stepsPerFlight=[17,17]&stepsPerStride=3"))
                .assertStatusCode(200)
                .assertEntity("{\"steps\":14}");
    }

    @Test
    public void should_return_correct_result_for_third_example() {
        testRoute.run(HttpRequest.GET("/steps?stepsPerFlight=[4,9,8,11,7,20,14]&stepsPerStride=2"))
                .assertStatusCode(200)
                .assertEntity("{\"steps\":50}");
    }
}
