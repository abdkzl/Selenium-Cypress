///<reference types="Cypress"/>

describe('file download', () => {
  it('verifies download', () => {
    cy.visit('https://the-internet.herokuapp.com/');
    cy.get("[href='\/download']").click()
    //cy.get("div > a:nth-of-type(9)").click()
    //cy.readFile('cypress/Download/example.jpg').should('contains', 'example')

  })
})
/*1>  npm install --save -dev cypress-downloadfile
  2> const {downloadFile} = require('cypress-downloadfile/lib/addPlugin')
module.exports = (on, config) => {
    on('task', {downloadFile})
  } */