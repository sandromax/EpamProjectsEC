package org.sandromax.fastest.controller.until.constants;

/**
 * Набор перечислений,
 * соответствующий ссылкам на jsp- страницы
 *
 * Например,
 interface UsersCrud {
 String LIST_USERS_JSP =
 "jsp/user.jsp";
 String EDIT_USER_JSP =
 "jsp/user.jsp";
 }
 */
public interface Pages {
    String START_PAGE = "index.jsp";
    String REGISTRATION_PAGE = "jsp/sign_in.jsp";
    String SIGN_UP_PAGE = "jsp/sign_up.jsp";

    String SUBJECTS_CATALOG = "jsp/subjects_catalog.jsp";
    String THEMES_CATALOG = "jsp/catalog_themes.jsp";

    String TEST = "jsp/test.jsp";
    String TEST_RESULT = "jsp/test_result.jsp";

    String ADMIN_PAGE = "jsp/admin_page.jsp";
}
