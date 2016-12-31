package io.toru.daggerbootcamp.util;

import android.text.Html;
import android.text.Spanned;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

public class Util {
    public static final String API_KEY  = "cf6c3f7a16e52bae0bef4c58901dec73";

    public static final String NAVER_BASE_URL = "https://openapi.naver.com/";
    public static final String NAVER_CLIENT_ID = "isOLaBw6C06tKlsRs8xn";
    public static final String NAVER_CLIENT_SECRET = "dYdx1rnfWX";

    public static final String MOVIE_API_KEY = "82c0cf7654b24b9775536f602367c26d";

    public static Spanned fromHtml(String source) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
            // noinspection deprecation
            return Html.fromHtml(source);
        }
        return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
    }
}