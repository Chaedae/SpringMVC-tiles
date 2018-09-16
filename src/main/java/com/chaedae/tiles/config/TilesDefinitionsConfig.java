package com.chaedae.tiles.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

/**
 * <h1>Apache-Tiles Definitions Config</h1>
 * xml : tiles.xml
 * @author ChaeDae
 *
 */
public class TilesDefinitionsConfig implements DefinitionsFactory {
	private static final Map<String, Definition> TILES_DEFINITIONS = new HashMap<>();
	
	@SuppressWarnings("serial")
	private static final Map<String, String> TILES_LAYOUTS = new HashMap<>() {
		{
			this.put("TILES_EMPTY_LAYOUT", "/WEB-INF/tiles/layouts/empty.jsp");
			this.put("TILES_LAYOUT", "/WEB-INF/tiles/layouts/layout.jsp");
		}
	};
	
	private static String TILES_HEADER = "/WEB-INF/tiles/layouts/header.jsp";
	private static String TILES_MENU   = "/WEB-INF/tiles/layouts/menu.jsp";
	private static String TILES_FOOTER = "/WEB-INF/tiles/layouts/footer.jsp";
	
	@Override
	public Definition getDefinition(String name, Request tilesContext) {
		return TILES_DEFINITIONS.get(name);
	}
	
	/**
	 * Init
	 */
	public static void addDefinitions() {
		// Login Layout
		setDefinitions("/chaedae/login/Login", "/WEB-INF/views/chaedae/login/Login.jsp", "TILES_EMPTY_LAYOUT");
		// default Layout
		setDefinitions("/chaedae/main/Main", "/WEB-INF/views/chaedae/main/Main.jsp", "TILES_LAYOUT");
	}
	
	/**
	 * Set Definitions
	 * @param name definition name
	 * @param bodyName 
	 * @param layouts layout name
	 */
	public static void setDefinitions(String name, String bodyName, String layout) {
		Map<String, Attribute> attributes = new HashMap<>();
		
		if (!StringUtils.equals(layout, "TILES_EMPTY_LAYOUT")) {
			attributes.put("header", new Attribute(TILES_HEADER));
			attributes.put("menu", new Attribute(TILES_MENU));
			attributes.put("footer", new Attribute(TILES_FOOTER));
		}
		
		attributes.put("body", new Attribute(bodyName));
		
		Attribute baseTemplate = new Attribute(TILES_LAYOUTS.get(layout));
		
		TILES_DEFINITIONS.put(name, new Definition(name, baseTemplate, attributes));
	}

}
