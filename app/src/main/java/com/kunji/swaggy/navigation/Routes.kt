package com.kunji.swaggy.navigation

const val ROUT_HOME ="home"
const val ROUT_ABOUT ="about"
const val ROUT_CONTACT ="contacts"
const val ROUT_ITEM ="item"
const val ROUT_CATEGORY ="category"
const val ROUT_SPLASH ="splash"
const val ROUT_SCAFFOLD ="scaffold"
const val ROUT_DETAIL="detail"
const val ROUT_INTENT="intent"
const val ROUT_DASHBOARD="dashboard"
const val ROUT_DASHBOARD2="dashboard2"
const val ROUT_FORM="dashboard2"

//Auth
const val ROUT_REGISTER= "register"
const val ROUT_LOGIN= "login"



//CRUD
//Product
const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"