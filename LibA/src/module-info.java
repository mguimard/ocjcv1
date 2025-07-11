/**
 * 
 */
/**
 * 
*/

import com.example.kebab.IKebabService;
import com.liba.KebabServiceImpl;

module LibA {
	requires KebabInterfaceProject;
	
	provides IKebabService with KebabServiceImpl;
}