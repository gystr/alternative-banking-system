package utils.resources;

public class AdminPaths {

    //project paths
    public static String PRIMARY = "/ui/primaryScene.fxml";
    public static String ADMIN_PANEL = "/ui/adminPanel/adminPanel.fxml";
    public static String adminLogin = "/ui/login/AdminLogin.fxml";
    public static String loanInfo = "/ui/loanDetail/LoanDetailAlert.fxml";


    public static String LIGHT_PRIMARY_THEME = "/utils/resources/stylesheets/primarySceneLight.css";
    public static String MCDONALDS_PRIMARY_THEME = "/utils/resources/stylesheets/primarySceneMcdonalds.css";
    public static String DARK_PRIMARY_THEME = "/utils/resources/stylesheets/primarySceneDark.css";

    public static String MCDONALDS_BODY_THEME  = "/utils/resources/stylesheets/bodyComponentMcdonalds.css";
    public static String  LIGHT_BODY_THEME = "/utils/resources/stylesheets/bodyComponentLight.css";
    public static String DARK_BODY_THEME = "/utils/resources/stylesheets/bodyComponentDark.css";



    //server paths
    public final static String BASE_DOMAIN = "localhost";
//    public final static String APPLICATION_NAME = "/web_Web_exploded";
    public final static String APPLICATION_NAME = "/web_Web";
    public final static String FULL_SERVER_PATH = "http://" + BASE_DOMAIN + ":8080" + APPLICATION_NAME;

    public final static String LOGIN_PAGE = FULL_SERVER_PATH + "/user/login";
    public final static String LOGOUT = FULL_SERVER_PATH + "/user/logout";
    public final  static String ADVANCE_TIME = FULL_SERVER_PATH + "/admin/time/advance";
    public final  static String ADMIN_SNAPSHOT = FULL_SERVER_PATH + "/admin/snapshot";
    public final  static String ADMIN_REWIND_TOGGLE = FULL_SERVER_PATH + "/admin/rewind/toggle";
    public final  static String ADMIN_REWIND_INCREASE = FULL_SERVER_PATH + "/admin/rewind/increase";
    public final  static String ADMIN_REWIND_DECREASE = FULL_SERVER_PATH + "/admin/rewind/decrease";
}
