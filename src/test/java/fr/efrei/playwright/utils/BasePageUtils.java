package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;

public abstract class BasePageUtils {
    protected final Page page;

    public BasePageUtils(Page page) {
        this.page = page;
    }
}
