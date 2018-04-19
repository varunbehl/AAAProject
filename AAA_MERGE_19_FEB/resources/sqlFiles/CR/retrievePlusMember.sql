select 
*
FROM TOKYO_ERS_HIST.ARCH_CALL

INNER JOIN TOKYO_INQ.MEMBERSHIPX
ON ARCH_CALL.SC_CALL_MBR_ID=MEMBERSHIPX.MBR_ID

INNER JOIN TOKYO_INQ.MEMBERX
ON (ARCH_CALL.SC_CALL_MBR_ID=MEMBERX.MBR_ID and ARCH_CALL.SC_CALL_ASC_ID=MEMBERX.ASSOC_MBR_ID) where SC_DT > '01-JAN-17' and CHG_ENTITLEMENT = 'Y' and MEMBERSHIPX.MBRS_STS_CD = 'A' and PLUS_IND = 'Y' AND rownum < 1000
	  ORDER BY dbms_random.value