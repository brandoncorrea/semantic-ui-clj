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
      (into component children)))

(def button (partial build-component :button))
(def button-or (partial build-component :button-or))
(def container (partial build-component :container))
(def flag (partial build-component :flag))
(def divider (partial build-component :divider))
