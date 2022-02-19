(ns semantic-ui.tag)

(defn as [default {:keys [as]}]
  (or (and (fn? as) as) (keyword as) default))
(def as-button (partial as :button))
(def as-div (partial as :div))
(def as-i (partial as :i))
