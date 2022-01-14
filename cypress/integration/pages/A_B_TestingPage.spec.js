
export function visitPage(){
    

    cy.visit(Cypress.config("baseurl"))}

  

export const titleCSS='#content > div > h3'

export const descriptionCSS='#content > div > p'
export const abTestLinkCSS=':nth-child(1) > a'
export const descriptionExpText="\n    Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through)."
