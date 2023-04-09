# Tên : Nguyễn Hoàng Thái
# MSSV: 20009931

import pandas as pd
import numpy as np 
import matplotlib.pyplot as plt
import scipy.stats as st
from scipy.stats import norm

# bài 1 
data = pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\18_M&M.xls')
print(data)
df = pd.DataFrame( data, columns=[  'Red',  'Orange',  'Yellow',  'Brown',   'Blue',  'Green'])
# n: kích thước mẫu kẹo có màu xanh lá = 19
n = df['Red'].count()
# N: kích thước mẫu kẹo có màu bất kì = 100
N = df['Blue'].count() + df['Red'].count() + df['Orange'].count() + df['Yellow'].count() + df['Green'].count()  + df['Brown'].count()

print('Tỉ lệ là: ', n/N )
p = 0.2
p_mu = n/N
q_mu = 1 - p_mu
z = ( p_mu - p ) / np.sqrt((p*(1-p))/N)
alpha = 0.05
Z_alpha_chia2 = (-1)*st.norm.ppf(.025, 0,1)
print('Z_alpha_chia2 = ',Z_alpha_chia2)
if((z>(-1)*Z_alpha_chia2) or (z<Z_alpha_chia2)):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')

#bài 2
data = pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\03_FRESH15.xls')
print(data)
df= pd.DataFrame(data, columns=['SEX','WTSEP','WTAPR','BMISP','BMIAP'])
#Số lượng Nam
n = df.query('SEX=="M"')['SEX'].count()
print('n= ',n)
#tổng sl sv khảo sát
N = df['SEX'].count()
print('N= ', N)
#Kiểm định giả thuyết
#H0: p=0.5
#Ha: p#0.5
p=0.5
p_mu=n/N
q_mu=1-p_mu

z=(p_mu-p)/np.sqrt((p*(1-p))/N)
alpha=0.05
print('Z= ',z)
#-z_alpha_chia2
Z_alpha_chia2 = (-1)*st.norm.ppf(.025, 0,1)
print('Z_alpha_chia2 = ',Z_alpha_chia2)
if((z>(-1)*Z_alpha_chia2) or (z<Z_alpha_chia2)):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')


#bài 3
data = pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\06_BEARS.xls')
print(data)
df= pd.DataFrame(data, columns=['AGE',	'MONTH',	'SEX',	'HEADLEN',	'HEADWTH',	'NECK',	'LENGTH',	'CHEST',	'WEIGHT'])
#Số lượng gấu đực
n = df.query('SEX== 1')['SEX'].count()
print('n= ',n)
#tổng sl sv khảo sát
N = df['SEX'].count()
print('N= ', N)
#Kiểm định giả thuyết
#H0: p=0.5
#Ha: p#0.5
p=0.5
p_mu=n/N
q_mu=1-p_mu
z=(p_mu-p)/np.sqrt((p*(1-p))/N)
alpha=0.05
print('Z= ',z)
#-z_alpha_chia2
Z_alpha_chia2 = (-1)*st.norm.ppf(.025, 0,1)
print('Z_alpha_chia2 = ',Z_alpha_chia2)
if((z>(-1)*Z_alpha_chia2) or (z<Z_alpha_chia2)):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')

#bài 4
data= pd.read_excel('/content/09_MOVIES.xls')
print(data)
df=pd.DataFrame(data , columns=['Title' , 'MPAA' , 'Budget' , 'Gross' , 'Length' , 'Rating'])

N = df['Title'].count()
print('N= ',N)
phim_R = df.query('MPAA=="R"')['MPAA']
n = phim_R.count()
print('n= ',n)

#Kiểm định giả thuyết
#H0: p=0.55
#Ha: p#0.55
p=0.55
p_mu=n/N
q_mu=1-p_mu

z=(p_mu-p)/np.sqrt((p*(1-p))/N)
alpha=0.01
print('Z= ',z)
#-z_alpha_chia2
Z_alpha_chia2 = (-1)*st.norm.ppf(.005,0,1)
print('Z_alpha_chia2 = ',Z_alpha_chia2)
if((z>(-1)*Z_alpha_chia2) or (z<Z_alpha_chia2)):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')

# bài 5
col_names = ['Dai']
data= pd.read_excel('/content/19_SCREWS.xls',names=col_names)
print(data)
df=pd.DataFrame(data)
n = df['Dai'].count()
print('N= ',n)
#Kiểm định giả thuyết
#H0: mu=0.75
#Ha: mu#0.75
mu = 0.75
x_gach = df['Dai'].mean()
print('X_gach là: ',x_gach)
xich_ma=0.012
z=(x_gach-mu)/(xich_ma/np.sqrt(n))
print('Z= ',z)
alpha=0.05
#-z_alpha_chia2
Z_alpha_chia2 = (-1)*st.norm.ppf(.025,0,1)
print('Z_alpha_chia2 = ',Z_alpha_chia2)
if((z>(-1)*Z_alpha_chia2) or (z<Z_alpha_chia2)):
  print('Fail to reject H0, không có bằng chứng để bác bỏ H0 ')
else:
  print('Bác bỏ H0')