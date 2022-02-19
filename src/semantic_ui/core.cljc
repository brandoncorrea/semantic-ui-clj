(ns semantic-ui.core
  (:require [semantic-ui.options :as options]
            [semantic-ui.tag :as tag]))

(defn button [& args]
  (let [[options children] (options/parse-args args)
        component [(tag/tag-name :button options) (options/button options)]]
    (if-not (empty? children)
      (concat component children)
      component)))

(defn container [& args]
  (let [[options children] (options/parse-args args)
        component [(tag/tag-name :container options) (options/container options)]]
    (if-not (empty? children)
      (concat component children)
      component)))

(defn flag [options]
  [(tag/tag-name :flag options) (options/flag options)])
