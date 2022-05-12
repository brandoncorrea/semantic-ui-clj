(ns semantic-ui.core.container-spec
  (:require [speclj.core :refer :all]
            [semantic-ui.core :refer :all]))

(describe "container"
  (context "default structure"
    (it "results in a vector with no children"
      (should (vector? (container))))
    (it "renders as div with class ui container"
      (should= [:div {:class "ui container"}] (container)))
    (it "has no children when the only parameter is a map"
      (should= [:div {:class "ui container"}] (container {})))
    (it "has one child after options"
      (should= [:div {:class "ui container"} [:p "Hello"]] (container {} [:p "Hello"])))
    (it "has two children after options"
      (should= [:div {:class "ui container"}
                [:h1 "Header"]
                [:h2 "Subheader"]]
               (container {} [:h1 "Header"] [:h2 "Subheader"])))
    (it "has no options and two children"
      (should= [:div {:class "ui container"}
                [:span "Something else"]
                [:p "Chicken"]]
               (container [:span "Something else"] [:p "Chicken"]))))

  (context "options"
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
        (should= {:class (str "ui " (name alignment) " aligned container")}
                 (second (container {:text-align alignment})))))
    (it "can justify text content"
      (should= {:class "ui justified container"} (second (container {:text-align :justified}))))
    (it "can have additional classes using class-name"
      (should= {:class "ui container and-another class"}
               (second (container {:class-name "  and-another class  "}))))))

