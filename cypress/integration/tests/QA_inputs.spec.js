//<reference types = "Cypress"/>


it.skip('inputs_number', function () {
    cy.visit('https://the-internet.herokuapp.com/inputs')
 
    cy.get("[type='number']").click().type("985624885")
 })

 
it.only('inputs_e', function () {
    cy.visit('https://the-internet.herokuapp.com/inputs')
 
    cy.get("[type='number']").click().type("e")
 })