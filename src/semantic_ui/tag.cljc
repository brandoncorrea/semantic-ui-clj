(ns semantic-ui.tag)

(defn as [default {:keys [as]}]
  (or (and (fn? as) as) (keyword as) default))
(def as-button (partial as :button))
(def as-div (partial as :div))
(def as-i (partial as :i))

(defmulti tag-name (fn [kind & _] kind))

(defmethod tag-name :button [_ options]
  (as-button options))
(defmethod tag-name :container [_ options]
  (as-div options))
(defmethod tag-name :flag [_ options]
  (as-i options))