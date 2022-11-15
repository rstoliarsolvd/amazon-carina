package com.solvd.carina.amazon.constants;

import com.qaprosoft.carina.core.foundation.utils.R;

public class Const {
    public static final String HOME_LOGO_URL = R.CONFIG.get("TEST.url_logo");
    public static final String HOME_URL = R.CONFIG.get("TEST.url");
    public static final String TODAYS_URL = "https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb";
    public static final String SIGNIN_URL = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
    public static final String LOG4J_CONF_PATH = R.CONFIG.get("path_log4j");
    public static final String LOCAL_HOST = R.CONFIG.get("TEST.selenium_url");
    public static final String SCREEN_SHOT_PATH = R.CONFIG.get("path_screenshot");
}
