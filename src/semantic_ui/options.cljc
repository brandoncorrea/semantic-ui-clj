(ns semantic-ui.options
  (:require [semantic-ui.class-name :as class-name]))

(defmulti options (fn [kind & _] kind))
(defmethod options :button [_ {:keys [on-click role toggle active type label-position tab-index] :as options}]
  (merge
    (when toggle {:aria-pressed (or active false)})
    (when (some #{type} [:button :submit :reset]) {:type (subs (str type) 1)})
    (when role {:role role})
    (when on-click {:on-click on-click})
    (when label-position {:tab-index 0})
    (when tab-index {:tab-index tab-index})
    {:class (class-name/button options)}))
(defmethod options :container [_ options]
  {:class (class-name/container options)})
(defmethod options :flag [_ options]
  {:class (class-name/flag options)})