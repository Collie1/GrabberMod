package io.github.collie1.grabbermod.datagen;

import io.github.collie1.grabbermod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class CollieModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RecipeGenerator::new);
	}

	public static class RecipeGenerator extends FabricRecipeProvider {
		private RecipeGenerator(FabricDataOutput generator) {
			super(generator);
		}

		@Override
		public void generate(RecipeExporter exporter) {
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.grabber, 1)
					.pattern("b b")
					.pattern("isi")
					.pattern(" s ")

					.input('b', Items.SLIME_BALL)
					.input('i', Items.IRON_INGOT)
					.input('s', Items.STICK)

					.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
					.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
					.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))

					.offerTo(exporter, new Identifier(getRecipeName(ModItems.grabber)));


		}
	}

}
