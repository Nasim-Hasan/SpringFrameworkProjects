package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by jt on 6/17/17.
 */
public class CategoryTest {

    private Category category;
    private Recipe objRecipe;

    @Before
    public void setUp(){
        this.category = new Category();
        this.objRecipe = new Recipe();

    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
        String desc = "Tasty";

        category.setDescription(desc);

        assertEquals(desc, category.getDescription());
    }

    @Test
    public void getRecipes() throws Exception {

        Set<Recipe> recipeCollection = new HashSet<Recipe>();

        objRecipe.setDescription("Tasty");
        objRecipe.setCookTime(20);

        recipeCollection.add(objRecipe);

        objRecipe.setDescription("Awful");
        objRecipe.setCookTime(40);

        recipeCollection.add(objRecipe);

        category.setRecipes(recipeCollection);

        assertEquals(2,category.getRecipes().size());
    }

}