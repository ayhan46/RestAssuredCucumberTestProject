Feature: Kullanici olarak otel rezervasyonu oluşturabilirim

  Scenario: Kullanici bir otel rezervasyonu oluşturabilir ve rezervasyonu silebilir
    Given Kullanici yeni bir rezervasyon oluşturuyor
    And Kullanici rezervasyon için gereken bilgileri veriyor
    When Kullanici otel rezervasyonu yaratiyor
    Then Rezervasyon basarili bir sekilde olusturuldu
    And Kullanici olusturulan rezervasyonu iptal ediyor