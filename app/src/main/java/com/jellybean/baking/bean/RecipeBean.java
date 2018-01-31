package com.jellybean.baking.bean;

import java.util.List;

/**
 * @author jellybean.
 * @Date 2018/1/31.
 * @Time 上午12:52.
 */
public class RecipeBean {

	/**
	 * id : 1 name : Nutella Pie ingredients :
	 * [{"quantity":2,"measure":"CUP","ingredient":"Graham Cracker
	 * crumbs"},{"quantity":6,"measure":"TBLSP","ingredient":"unsalted butter,
	 * melted"},{"quantity":0.5,"measure":"CUP","ingredient":"granulated
	 * sugar"},{"quantity":1.5,"measure":"TSP","ingredient":"salt"},{"quantity":5,"measure":"TBLSP","ingredient":"vanilla"},{"quantity":1,"measure":"K","ingredient":"Nutella
	 * or other chocolate-hazelnut
	 * spread"},{"quantity":500,"measure":"G","ingredient":"Mascapone Cheese(room
	 * temperature)"},{"quantity":1,"measure":"CUP","ingredient":"heavy
	 * cream(cold)"},{"quantity":4,"measure":"OZ","ingredient":"cream
	 * cheese(softened)"}] steps : [{"id":0,"shortDescription":"Recipe
	 * Introduction","description":"Recipe
	 * Introduction","videoURL":"https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/-intro-creampie.mp4","thumbnailURL":""},{"id":1,"shortDescription":"Starting
	 * prep","description":"1. Preheat the oven to 350°F. Butter a 9\" deep dish pie
	 * pan.","videoURL":"","thumbnailURL":""},{"id":2,"shortDescription":"Prep the
	 * cookie crust.","description":"2. Whisk the graham cracker crumbs, 50 grams
	 * (1/4 cup) of sugar, and 1/2 teaspoon of salt together in a medium bowl. Pour
	 * the melted butter and 1 teaspoon of vanilla into the dry ingredients and stir
	 * together until evenly
	 * mixed.","videoURL":"https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/2-mix-sugar-crackers-creampie.mp4","thumbnailURL":""},{"id":3,"shortDescription":"Press
	 * the crust into baking form.","description":"3. Press the cookie crumb mixture
	 * into the prepared pie pan and bake for 12 minutes. Let crust cool to room
	 * temperature.","videoURL":"https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/4-press-crumbs-in-pie-plate-creampie.mp4","thumbnailURL":""},{"id":4,"shortDescription":"Start
	 * filling prep","description":"4. Beat together the nutella, mascarpone, 1
	 * teaspoon of salt, and 1 tablespoon of vanilla on medium speed in a stand
	 * mixer or high speed with a hand mixer until
	 * fluffy.","videoURL":"https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/1-mix-marscapone-nutella-creampie.mp4","thumbnailURL":""},{"id":5,"shortDescription":"Finish
	 * filling prep","description":"5. Beat the cream cheese and 50 grams (1/4 cup)
	 * of sugar on medium speed in a stand mixer or high speed with a hand mixer for
	 * 3 minutes. Decrease the speed to medium-low and gradually add in the cold
	 * cream. Add in 2 teaspoons of vanilla and beat until stiff peaks
	 * form.","videoURL":"","thumbnailURL":"https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/7-add-cream-mix-creampie.mp4"},{"id":6,"shortDescription":"Finishing
	 * Steps","description":"6. Pour the filling into the prepared crust and smooth
	 * the top. Spread the whipped cream over the filling. Refrigerate the pie for
	 * at least 2 hours. Then it's ready to
	 * serve!","videoURL":"https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/9-add-mixed-nutella-to-crust-creampie.mp4","thumbnailURL":""}]
	 * servings : 8 image :
	 */

	private int id;
	private String name;
	private int servings;
	private String image;
	private List<IngredientsBean> ingredients;
	private List<StepsBean> steps;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<IngredientsBean> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientsBean> ingredients) {
		this.ingredients = ingredients;
	}

	public List<StepsBean> getSteps() {
		return steps;
	}

	public void setSteps(List<StepsBean> steps) {
		this.steps = steps;
	}

	public static class IngredientsBean {
		/**
		 * quantity : 2 measure : CUP ingredient : Graham Cracker crumbs
		 */

		private int quantity;
		private String measure;
		private String ingredient;

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getMeasure() {
			return measure;
		}

		public void setMeasure(String measure) {
			this.measure = measure;
		}

		public String getIngredient() {
			return ingredient;
		}

		public void setIngredient(String ingredient) {
			this.ingredient = ingredient;
		}
	}

	public static class StepsBean {
		/**
		 * id : 0 shortDescription : Recipe Introduction description : Recipe
		 * Introduction videoURL :
		 * https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/-intro-creampie.mp4
		 * thumbnailURL :
		 */

		private int id;
		private String shortDescription;
		private String description;
		private String videoURL;
		private String thumbnailURL;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getVideoURL() {
			return videoURL;
		}

		public void setVideoURL(String videoURL) {
			this.videoURL = videoURL;
		}

		public String getThumbnailURL() {
			return thumbnailURL;
		}

		public void setThumbnailURL(String thumbnailURL) {
			this.thumbnailURL = thumbnailURL;
		}
	}
}