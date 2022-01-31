//<reference types = "Cypress"/>

it.skip('scrollTo_center', function () {
   cy.visit('https://the-internet.herokuapp.com/infinite_scroll')

   cy.get('.jscroll-inner > div:nth-of-type(2)').scrollTo('center', { ensureScrollable: false })
      .should('be.visible')
   //                              //eminKaydırılabilir

})

it.only('scrollTo_bottom', function () {
   cy.visit('https://the-internet.herokuapp.com/infinite_scroll')

   cy.window().scrollTo("bottom") //.should('be.visible')
   cy.pause().scrollTo("top") //.should('be.visible')
})
 
it.skip('scrollTo_bottom', function () {
   cy.visit('https://the-internet.herokuapp.com/infinite_scroll')

   cy.get('.jscroll-inner > div:nth-of-type(2) ').scrollIntoView()
   .should('be.visible')
})


//scrollIntoView()