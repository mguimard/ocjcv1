/**
 * 
 */
/**
 * 
 */
// import => dépendances du module

import com.example.kebab.IKebabService;

module training {
	requires java.sql;
	requires LibB;
	requires LibA;
	requires KebabInterfaceProject;
	
	uses IKebabService;
	
	// export -> les autres modules peuvent importer
}