package com.example.scaffold.frameworks.persistence.aggregates;

interface TestAggregates {
    void add(TestAggregate aggregate);
    void clearByName(String name);
    void clearByNameAndId(String name, String id);
    void clearByNameAndIdAndGender(String name, String id, String gender);
    TestAggregate getByName(String name);
    TestAggregate getByNameAndId(String name, String id);
    TestAggregate getByNameAndIdAndGender(String name, String id, String gender);
    boolean containsByName(String name);
    boolean containsByNameAndId(String name, String id);
    boolean containsByNameAndIdAndGender(String name, String id, String gender);
}