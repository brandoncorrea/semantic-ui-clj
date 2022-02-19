(ns semantic-ui.core.container-spec
  (:require [speclj.core :refer :all]
            [semantic-ui.core :refer :all]))

(describe "container"
  (it "results in a vector"
    (should (vector? (container))))
  (it "renders as div with class ui container"
    (let [[tag options _] (container)]
      (should= :div tag)
      (should= {:class "ui container"} options)))
  (it "renders as :span"
    (should= :span (first (container {:as :span}))))
  (it "renders as \"p\""
    (should= :p (first (container {:as "p"}))))
  (it "can render as a function"
    (should= identity (first (container {:as identity}))))
  (it "can be fluid"
    (should= {:class "ui fluid container"} (second (container {:fluid true}))))
  (it "can be a text container"
    (should= {:class "ui text container"} (second (container {:text true}))))
  (for [alignment [:left :center :right]]
    (it (str "can be aligned " alignment)
      (should= {:class (str "ui " (subs (str alignment) 1) " aligned container")}
               (second (container {:text-align alignment})))))
  (it "can justify text content"
    (should= {:class "ui justified container"} (second (container {:text-align :justified}))))
  (it "can have additional classes using class-name"
    (should= {:class "ui container and-another class"}
             (second (container {:class-name "  and-another class  "})))))

