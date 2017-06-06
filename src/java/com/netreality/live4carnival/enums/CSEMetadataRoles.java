/**
 * 
 */
package com.netreality.live4carnival.enums;

/**
 * @author JahLion
 *
 */
public enum CSEMetadataRoles {
	
	requestRole("request"),
	exampleRole("example"),
	relatedRole("related"),
	correctionRole("correction"),
	subsetRole("subset"),
	supersetRole("supserset");
	
	CSEMetadataRoles(String metaDataRoleName)
	{
		this.roleName = metaDataRoleName;
	}
	
	private String roleName;

}
