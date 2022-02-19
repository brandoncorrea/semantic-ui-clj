(ns semantic-ui.core
  (:require [clojure.string :as s]
            [semantic-ui.class-name :as class-name]
            [semantic-ui.options :as options]
            [semantic-ui.tag :as tag]))

(defn button
  ([] (button ""))
  ([options-or-text]
   (cond (map? options-or-text) (button options-or-text "")
         :else (button {} options-or-text)))
  ([{:keys [content] :as options} text]
   [(tag/as-button options)
    (options/button options)
    (let [text (or content text)]
      (when-not (s/blank? text) text))]))

(defn container
  ([] (container {}))
  ([options]
   [(tag/as-div options) {:class (class-name/container options)}]))

(defn flag [options]
  [(tag/as-i options) {:class (class-name/flag options)}])
