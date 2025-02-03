package com.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Fyiai {

    public static final Target LOGO = Target.the("FYI Logo").locatedBy("//img[@class='u-align-left u-image u-image-default u-image-1']");
    public static final Target BOTTOM_MENU = Target.the("Bottom Menu").locatedBy("//nav[@class='u-menu u-menu-one-level u-offcanvas u-menu-1']");
    public static final Target BOTTOM_PHRASE = Target.the("'©2024 FYI.FYI, Inc.'").locatedBy("//p[@class='u-small-text u-text u-text-variant u-text-1']");
    public static final Target HAMBURGUER_MENU = Target.the("'Hamburguer Menu'").locatedBy("(//*[name()='svg'][@class='u-svg-link'])[1]");
    public static final Target HAMBURGUER_MENU_CONTAINER = Target.the("Hamburguer Menu Container").locatedBy("//div[@class='u-inner-container-layout u-sidenav-overflow']");
    public static final Target HAMBURGUER_MENU_OPT_LIST = Target.the("Hamburguer Menu Options List").locatedBy("//ul[@class='u-align-left u-custom-font u-heading-font u-nav u-popupmenu-items u-text-hover-custom-color-1 u-unstyled u-nav-2']");
    public static final Target MENU_HELP = Target.the("option 'Help'").locatedBy("(//a[@class='u-button-style u-nav-link'][text()='Help'])[1]");
    public static final Target TITLE_PAGE_HELP = Target.the("'Need Help? We've got your back' title").locatedBy("//h1[@class='support-home-title']");
    public static final Target BUTTON_CONTACT_SUPPORT = Target.the("button 'Contact Support'").locatedBy("//button[text()='Contact Support']");
    public static final Target TITLE_SUBMIT_A_REQUEST = Target.the("'Submit a request' title").locatedBy("//h1[contains(text(),'Submit a request')]");
    public static final Target QUERY_FIELD = Target.the("Query field").located(By.id("query"));
    public static final Target TITLE_RESULTS = Target.the("Results").locatedBy("//h1[@class='search-results-subheading']");
    public static final Target PAG_NEXT_BUTTON = Target.the("Button 'Next'").locatedBy("//a[@class='pagination-next-link']");
    public static final Target RESULTS_QUERY = Target.the("Results").locatedBy("//ul[@class='search-results-list']/li");

}
