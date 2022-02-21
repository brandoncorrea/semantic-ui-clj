(ns semantic-ui.core.flag-spec
  (:require [speclj.core :refer :all]
            [semantic-ui.core :refer :all]))

(describe "flag"
  (it "renders as vector"
    (should (vector? (flag {:name "us"}))))
  (it "renders as an 'i' element"
    (should= :i (first (flag {:name "us"}))))
  (it "renders 'as' a :div"
    (should= :div (first (flag {:as :div :name "us"}))))
  (it "adds country name to beginning of class list"
    (should= "france flag" (:class (second (flag {:name "france"}))))
    (should= "us flag" (:class (second (flag {:name "us"})))))
  (it "appends class list with additional classes"
    (let [[_ options] (flag {:name "ad" :class-name "  something-else  "})]
      (should= "ad flag something-else" (:class options)))))
