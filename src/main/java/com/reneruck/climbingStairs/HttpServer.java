package com.reneruck.climbingStairs;

/**
 * Created by Rene on 01/05/2017.
 */
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.unmarshalling.StringUnmarshallers;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class HttpServer extends AllDirectives {

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("routes");

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        HttpServer webServer = new HttpServer();

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = webServer.createRoute().flow(system, materializer);
        http.bindAndHandle(routeFlow, ConnectHttp.toHost("localhost", 8080), materializer);
    }


    Route createRoute() {
        return route(
                path("steps", () ->
                        get(() ->
                                parameter("stepsPerFlight", stepsPerFlight ->
                                        parameter(StringUnmarshallers.INTEGER,"stepsPerStride", stepsPerStride ->
                                                complete(new StepsCalculatorController().handle(stepsPerFlight, stepsPerStride).toString())
                                        )
                                )
                        )
                )
        );
    }
}