(ns semantic-ui.core.divider-spec
  (:require [speclj.core :refer :all]
            [semantic-ui.core :refer :all]))

(defn- class-should= [expected options]
  (should= expected (-> options divider second :class)))

(describe "Divider"
  (it "is a vector"
    (should (vector? (divider))))
  (it "renders as div with class 'ui divider'"
    (should= [:div {:class "ui divider"}] (divider)))
  (it "contains one child"
    (should= [:div {:class "ui divider"} [:h1 "Hello!"]]
             (divider [:h1 "Hello!"])))
  (it "contains two children"
    (should= [:div {:class "ui divider"} [:h2 "This is some text"] [:p "Goodbye"]]
             (divider [:h2 "This is some text"] [:p "Goodbye"])))
  (it "can be rendered as another tag"
    (should= [:span {:class "ui divider"}] (divider {:as :span})))
  (it "can append class names to component"
    (class-should= "ui divider new class names" {:class-name "new class names"}))
  (it "can clear the content above it"
    (class-should= "ui clearing divider" {:clearing true}))
  (it "can be fitted without any space above or below it"
    (class-should= "ui fitted divider" {:fitted true}))
  (it "can divide content without creating a dividing line"
    (class-should= "ui hidden divider" {:hidden true}))
  (it "can segment content horizontally"
    (class-should= "ui horizontal divider" {:horizontal true}))
  (it "can have its colors inverted"
    (class-should= "ui inverted divider" {:inverted true}))
  (it "can provide greater margins to divide sections of content"
    (class-should= "ui section divider" {:section true}))
  (it "can segment content vertically"
    (class-should= "ui vertical divider" {:vertical true}))

  )