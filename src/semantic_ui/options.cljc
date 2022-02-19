(ns semantic-ui.options
  (:require [semantic-ui.class-name :as class-name]))

(defn parse-args [[first-arg & children :as args]]
  (if (map? first-arg)
    [first-arg children]
    [{} args]))

(defn button [{:keys [on-click role toggle active type] :as options}]
  (merge
    (when toggle {:aria-pressed (or active false)})
    (when (some #{type} [:button :submit :reset]) {:type (subs (str type) 1)})
    (when role {:role role})
    (when on-click {:on-click on-click})
    {:class (class-name/button options)}))