package org.csu.mypetstore.persistence;
import org.csu.mypetstore.domain.Category;
import java.util.List;

public interface CategoryDAO {


    //select all Category
    List<Category>getCategoryList();
    //select a Category By a Id
    Category getCategory(String categoryId);
}
