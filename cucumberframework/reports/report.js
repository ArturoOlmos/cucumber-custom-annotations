$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/firstFeature.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "some other precondition",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.some_other_precondition()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I complete action",
  "keyword": "When "
});
formatter.match({
  "location": "steps.i_complete_action()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});