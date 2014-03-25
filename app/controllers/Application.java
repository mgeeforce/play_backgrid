package controllers;

import static play.data.Form.form;

import com.fasterxml.jackson.databind.JsonNode;

import models.Item;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return list(0, "id", "asc", "");
    }

    /**
     * Display the paginated list of Items.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on items
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            index.render(
                Item.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }

    public static Result items() {
    	return ok(Json.toJson(Item.find.all()));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result create() {
    	Logger.info("in create ...");
        JsonNode json = request().body().asJson();
        Item item = Json.fromJson(json, Item.class);
        item.save();
        return ok(Json.toJson(item));
    }
    
    /**
     * Display the 'new item form'.
     */
    public static Result createItem() {
        Form<Item> itemForm = form(Item.class).bindFromRequest();
//        if(itemForm.hasErrors()) {
//            return badRequest(createExpenseReportForm.render(itemForm);
//        }
        itemForm.get().save();
        flash("success", "Plant " + itemForm.get().name + " has been created");
        return redirect(routes.Application.index());
      }
    
    @BodyParser.Of(BodyParser.Json.class)
    public static Result update(Long id) {
    	JsonNode json = request().body().asJson();
        Item item = Json.fromJson(json, Item.class);
        item.update();		
        flash("success", "Item " + item.name + " has been updated");
        return ok(Json.toJson(item));
    }
    
    public static Result delete(Long id) {
    	Item.find.ref(id).delete();
        flash("success", "Item "+id+" has been deleted");
        return index();

    }
    
    public static Result deleteGET(Long id) {
    	Item.find.ref(id).delete();
        flash("success", "Item "+id+" has been deleted");
        return redirect(
                routes.Application.index()
            );
    }
    
    public static Form<Item> getForm() {
		Form<Item> itemForm = form(Item.class);
		return itemForm;
    }
}
