(ns semantic-ui.core.button-or-spec
  (:require [speclj.core :refer :all]
            [semantic-ui.core :refer :all]))

(describe "button-or"
  (it "renders as :div with 'or' class"
    (should= [:div {:class "or"}] (button-or)))
  (for [text ["ou" "other"]]
    (it (str "includes data-text: " text)
      (should= [:div {:class "or" :data-text text}] (button-or {:text text}))))
  (it "adds additional classes to the element"
    (should= [:div {:class "or this thing"}] (button-or {:class-name "this thing"})))
  (for [tag [:a :p]]
    (it (str "renders button as tag: " tag)
      (should= [tag {:class "or"}] (button-or {:as tag}))))
  )