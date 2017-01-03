package io.toru.daggerbootcamp.ui.activity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * Created by wonyoung on 2017. 1. 2..
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
