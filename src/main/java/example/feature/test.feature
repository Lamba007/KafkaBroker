Feature:  test
  Scenario: to test
    Given I add a sku
    |branch|quantity|
    |265   |200     |
    |300   |500     |

  Scenario: Learn stream
    Given I send the following
      | category | product | barcode | quantity |
      | toilet   | comb    | 5454    | 2        |
      | toilet   | paper   | 4547    | 20       |
      | kitchen  | towel   | 8985    | 6        |
      | wardrobe | hanger  | 2524    | 28       |
      | kitchen  | knife   | 8585    | 8        |