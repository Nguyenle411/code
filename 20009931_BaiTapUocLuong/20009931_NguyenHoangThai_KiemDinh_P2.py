# Tên : Nguyễn Hoàng Thái
# MSSV: 20009931

import pandas as pd
import numpy as np 
import matplotlib.pyplot as plt
import scipy.stats as st
from scipy.stats import norm

# Bài 6a
data = pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\13_VOLTAGE.xls')
df = pd.DataFrame(data)
n = df['Home'].count()
print('N là ', n )
# giả thuyết
# H0 : mu = 120
# Ha : mu # 120
mu = 120
x_gach  = df['Home'].mean()
print('X_gach lầ : ', x_gach )
xichma = 0.24
z = ( x_gach - mu ) / ( xichma/np.sqrt(n) )
print('Z là : ', z )
alpha = 0.01 
Pvalues = st.norm.cdf(z, 0, 1 )
if( z > Pvalues ):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')


# Bài 6b
print('\nb/')
data = pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\13_VOLTAGE.xls')
df = pd.DataFrame(data)
n = df['Home'].count()
print('N là ', n )
# giả thuyết
# H0 : mu <= 120
# Ha : mu > 120
mu = 120
x_gach  = df['Home'].mean()
print('X_gach lầ : ', x_gach )
xichma = 0.24
z = ( x_gach - mu ) / ( xichma/np.sqrt(n) )
print('Z là : ', z )
alpha = 0.01 
Pvalues = st.norm.cdf(z, 0, 1 )
if( z > Pvalues ):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')