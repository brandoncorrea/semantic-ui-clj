(ns semantic-ui.class-name
  (:require [clojure.string :as s]
            [semantic-ui.color :as color]
            [semantic-ui.size :as size]))

(defn- ->class [& names] (s/join " " (remove s/blank? (map #(s/trim (str %)) names))))

(defn button
  [{:keys [active animated attached
           basic circular class-name
           compact color disabled floated
           fluid inverted label-position
           loading negative positive
           primary secondary size toggle]}]
  (->class
    "ui"
    (case animated
      :fade "fade animated"
      :vertical "vertical animated"
      nil ""
      false ""
      "animated")
    (case label-position
      :right "right labeled"
      :left "left labeled"
      "")
    (case attached
      :top "top attached"
      :left "left attached"
      :bottom "bottom attached"
      :right "right attached"
      "")
    (case floated
      :left "left floated"
      :right "right floated"
      "")
    (when active "active")
    (when basic "basic")
    (when circular "circular")
    (when compact "compact")
    (when disabled "disabled")
    (when fluid "fluid")
    (when loading "loading")
    (when negative "negative")
    (when positive "positive")
    (when primary "primary")
    (when secondary "secondary")
    (when toggle "toggle")
    (get color/button color)
    (get size/button size)
    (when inverted "inverted")
    "button"
    class-name))

(defn container [{:keys [fluid text text-align class-name]}]
  (->class
    "ui"
    (when fluid "fluid")
    (when text "text")
    (case text-align
      :left "left aligned"
      :center "center aligned"
      :right "right aligned"
      :justified "justified"
      "")
    "container"
    class-name))

(defn flag [{:keys [name class-name]}]
  (->class name "flag" class-name))

