package donuttycoon;

import static spark.Spark.*;
import static donuttycoon.JsonUtil.*;
import java.sql.Connection;

public class DonutController {

    public DonutController(final DonutService donutService) {

        get("/donuts", (req, res) -> donutService.getAllDonuts(), json());

        get("/donuts/:id", (req, res) -> {
            String id = req.params(":id");
            Donut donut = donutService.getDonut(id);
            if (donut != null) {
                return donut;
            }
            res.status(400);
            return new ResponseError("No donut with id '%s' found", id);
        }, json());

        post("/donuts", (req, res) -> donutService.createDonut(
            req.queryParams("name"),
            req.queryParams("topping"),
            Integer.parseInt(req.queryParams("price"))
        ), json());

        put("/donuts/:id", (req, res) -> donutService.updateDonut(
            req.params(":id"),
            req.queryParams("name"),
            req.queryParams("topping"),
            Integer.parseInt(req.queryParams("price"))
        ), json());

        delete("/donuts/:id", (req, res) -> donutService.deleteDonut(
            req.params(":id")
        ), json());

        after((req, res) -> {
            res.type("application/json");
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            System.out.println(e.toString());
            res.body(toJson(new ResponseError(e.toString())));
        });
    }
}
