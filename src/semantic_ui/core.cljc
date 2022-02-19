(ns semantic-ui.core
  (:require [semantic-ui.options :as options]
            [semantic-ui.tag :as tag]))

(defn- parse-args [[first-arg & children :as args]]
  (if (map? first-arg)
    [first-arg children]
    [{} args]))

(defn- build-component [kind & args]
  (let [[options children] (parse-args args)
        component [(tag/tag-name kind options)
                   (options/options kind options)]]
    (if-not (empty? children)
      (concat component children)
      component)))

(def button (partial build-component :button))
(def container (partial build-component :container))
(def flag (partial build-component :flag))
