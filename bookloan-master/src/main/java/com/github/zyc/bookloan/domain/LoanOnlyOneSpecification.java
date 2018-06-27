package com.github.zyc.bookloan.domain;


public class LoanOnlyOneSpecification implements ISPecification<Member> {
    private Book wantedBook;

    public LoanOnlyOneSpecification(Book wantedBook) {
        this.wantedBook = wantedBook;
    }

    @Override
    public boolean isSatisfiedBy(Member member) {
        return member.getLoans().stream()
                .filter(loan -> loan.hasNotBeenReturned() && wantedBook.getISBN().equals(loan.getBook().getISBN()))
                .count()==0;
    }

    public Book getWantedBook() {
        return wantedBook;
    }

    public void setWantedBook(Book wantedBook) {
        this.wantedBook = wantedBook;
    }
}
