package com.icloud.refactoring._01_smell_mysterious_name._04_rename_field;

/**
 * record 클래스 사용 시 생성자를 만들어주고, getter 메소드 자동 생성 및 equals and hashCode 자동 생성
 */
public record StudyReview(String reviewer, String review) {

}
