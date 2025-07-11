/**
 * 
 */
/**
 * 
 */
import com.example.kebab.IKebabService;
import com.libb.AutreKebabImpl;

module LibB {
	requires KebabInterfaceProject;
	
	provides IKebabService with AutreKebabImpl;
}