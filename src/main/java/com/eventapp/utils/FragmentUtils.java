package com.eventapp.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class FragmentUtils {

    public static void setFragment(Activity activity, Fragment fragment, int id) {
        FragmentManager fm = activity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fr = fm.findFragmentById(id);

        if (fr != null) {
            ft.remove(fr);
        }

        ft.replace(id, fragment);
        ft.commit();
    }

    public static void setFragment(Activity activity, Fragment fragment, int id, String tag, String[] hideTags) {
        FragmentManager fm = activity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fr = fm.findFragmentByTag(tag);

        if (fr != null) {
            ft.remove(fr);
        }

        hideFragments(hideTags, fm, ft);
        ft.add(id, fragment, tag);
        ft.commit();
    }

    public static void restoreFragment(Activity activity, Fragment fragment, int id, String tag, String[] hideTags) {
        FragmentManager fm = activity.getFragmentManager();
        Fragment fr = fm.findFragmentByTag(tag);
        FragmentTransaction ft = fm.beginTransaction();

        hideFragments(hideTags, fm, ft);

        if (fr != null) {
            reloadFragment(fragment, id, tag, fr, ft);
        } else {
            ft.add(id, fragment, tag);
        }

        ft.commit();
    }

    public static void removeFragment(Activity activity, int id) {
        FragmentManager fm = activity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fr = fm.findFragmentById(id);

        if (fr != null) {
            ft.remove(fr);
        }

        ft.commit();
    }

    private static void reloadFragment(Fragment fragment, int id, String tag, Fragment fr, FragmentTransaction ft) {
        if (fr.isVisible()) {
            ft.remove(fr);
            ft.add(id, fragment, tag);
        } else {
            ft.show(fr);
        }
    }

    private static void hideFragments(String[] hideTags, FragmentManager fm, FragmentTransaction ft) {
        for (String t : hideTags) {
            Fragment f = fm.findFragmentByTag(t);
            if (f != null) {
                ft.hide(f);
            }
        }
    }
}
