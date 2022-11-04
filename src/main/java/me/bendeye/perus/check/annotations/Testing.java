package me.bendeye.perus.check.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation can be used when making a new check, To only make this check get registered
 * This can be useful when making checks like speed, Where you don't want to get flagged by the other checks.
 */

/**
 * Credits to NikV2
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Testing {
}