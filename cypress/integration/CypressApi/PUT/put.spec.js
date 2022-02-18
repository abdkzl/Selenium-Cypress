///<reference types="Cypress"/>

context("XML HTTP REQUEST -XHR",()=>{
  
    
  
    const url ='https://example.cypress.io/commands/network-requests'
   

    it("XHR example 2 - Post",()=>{

        cy.visit(url)
        cy.intercept({
            method : 'PUT',
            url : '**/comments/*'
        },
       {

        statusCode :404,
        body :{
            error : 'Bu bir error mesajidir'},
            headers : {'access-control-allow-origin' : '*'},
            delayMS : 3000
        }).as('putComment')
        cy.get('.btn.btn-warning.network-put').click()
        cy.wait('@putComment').its('response').then((response) =>{
            console.log(response)
        })
        cy.get('.network-put-comment').should('contain','Bu bir error mesajidir')

        })
      
        })

    