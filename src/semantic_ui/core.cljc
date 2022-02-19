(ns semantic-ui.core
  (:require [semantic-ui.class-name :as class-name]
            [semantic-ui.options :as options]
            [semantic-ui.tag :as tag]))

(defn button [& args]
  (let [[options children] (options/parse-args args)
        component [(tag/as-button options) (options/button options)]]
    (if-not (empty? children)
      (concat component children)
      component)))

(defn container [& args]
  (let [[options children] (options/parse-args args)
        component [(tag/as-div options) (options/container options)]]
    (if-not (empty? children)
      (concat component children)
      component)))

(defn flag [options]
  [(tag/as-i options) {:class (class-name/flag options)}])
